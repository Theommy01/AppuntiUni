/*
The company TravelSpaces decides to help tourists visiting a city in 
finding places that can keep their luggage for some time. The 
company establishes agreements with small shops in various areas of 
the city and acts as a mediator between these shops and the tourists 
that need to leave their luggage in a safe place.

To this end, the company wants to build a system, called 
LuggageKeeper, that offers tourists the possibility to: look for luggage 
keepers in a certain area; reserve a place for the luggage in the 
selected place; pay for the service when they are at the luggage 
keeper; and, optionally, rate the luggage keeper at the end of the 
service.
*/

abstract sig Status{}
one sig Safe extends Status{}
one sig Unsafe extends Status{}

sig Luggage{
    luggageStatus : one Status
}

sig EKey{}

sig User{
    owns : set Luggage,
    carries : set Luggage,
    hasKeys : set EKey
}

sig Locker{
    hasKey : lone EKey,
    storesLuggage : lone Luggage
}

sig Shop{
    lockers : some Locker
}

/*
any piece of luggage is safe if, and only if, it is with its owner, or it is stored in a 
locker that has an associated key, and the owner of the piece of luggage holds the 
key of the locker
*/

fact DAsafeLuggages {
    all lg : Luggage |
    lg.luggageStatus in Safe
    iff
    all u : User | lg in u.owns
    implies
    ( lg in u.carries
    or
    some lk : Locker | lg in lk.storesLuggage and
    lk.hasKey != none and
    lk.hasKey in u.hasKeys )
}

/*a key opens only one locker*/

fact requirement {
    all ek : EKey | no disj lk1, lk2: Locker | ek in lk1.hasKey 
    and
    ek in lk2.hasKey
}

/*• for each user all his/her luggage is safe*/

pred goal {
    all u : User, lg : Luggage | lg in u.owns
    implies
    lg.luggageStatus in Safe
}

/*
Given a locker that is free, GenKey associates with it a new 
electronic key
*/

pred GenKey[lk : Locker] {
    //precondition
    lk.hasKey = none
    //postcondition
    lk.storesLuggage' = lk.storesLuggage
    one ek : EKey | lk.hasKey' = ek
}