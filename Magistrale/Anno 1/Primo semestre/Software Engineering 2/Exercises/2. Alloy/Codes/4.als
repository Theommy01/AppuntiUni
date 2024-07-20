/*
Model a system handling messages, 
which can be deleted from a mailbox 
and later restored

We introduce the notion of "trash", 
from which messages can be restored

Some messages are in the trash (i.e., they 
are trashed), others are not
*/

var sig Message {}
var sig Trashed in Message {}

pred delete[ m: Message ]{
    m not in Trashed
    Trashed' = Trashed + m
    Message' = Message
}

pred restoreEnabled[ m:Message ]{
    m in Trashed
}

pred restore[ m: Message ]{
    restoreEnabled[m]
    Trashed' = Trashed - m
    Message' = Message
}

pred deleteTrashed{
    #Trashed > 0
    after #Trashed = 0
    Message' = Message-Trashed
}

pred doNothing{
    Message' = Message
    Trashed' = Trashed
}

pred receiveMessages{
    #Message' > #Message
    Trashed' = Trashed
}

fact systemBehavior {
    no Trashed
    always (
        (some m: Message | delete[m] or restore[m] )
    or
    deleteTrashed
    or
    receiveMessages
    or
    doNothing)
}

assert restoreAfterDelete{
    all m: Message | 
    always restore[m] implies once delete[m]
}

assert deleteAll{
    always ( ( Message in Trashed and deleteTrashed )
    implies
    after always no Message)
}

assert messagesNeverChange{
    always (Message' in Message and Message in Message')
}

assert ifMessagesNotDeletedTrashNotEmptied{
    ( always all m : Message | not delete[m] )
    implies
    always not deleteTrashed
}