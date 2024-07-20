/*
A semaphore can have one of the following colors: GREEN and RED

Two semaphores are used to regulate traffic at an intersection where 2 
roads meet. Each road is two-way. The semaphores must guarantee that 
traffic can proceed on one and only one of the two roads in both 
directions

Provide an Alloy model of the intersection, specifying the necessary 
invariants

While building the model, focus on those part of the roads that are 
close to the intersection. Disregard the fact that a road can participate to 
more than one intersection
*/

abstract sig Color{}
one sig GREEN extends Color{}
one sig RED extends Color{}

abstract sig Traffic{}
one sig FLOWING extends Traffic{}
one sig STOPPED extends Traffic{}

sig Semaphore {
    color: one Color
}

sig Road {
    traffic: one Traffic,
}

sig Intersection{
    connection: Semaphore -> Road //MAPS Semaphore to Road
}{
    #connection = 2
}

//Retrieves all the Roads of one Intersection
fun getIRoads[i :Intersection]: set Road {
    Semaphore.(i.connection)
}

//Retrieves the Roads connected to one semaphore
fun getSRoads[s :Semaphore]: set Road {
    s.(Intersection.connection)
}

//Retrieves all the Semaphores of one Intersection
fun getSemaphores[i :Intersection]: set Semaphore {
    (i.connection).Road
}

fact intersectionStructure{
//Intersection has exactly 2 roads and 2 semaphores
(all i : Intersection | 
  (let s = getSemaphores[i] | #s=2) and
  (let r = getIRoads[i] | #r=2)
)
and
// All semaphores are connected to only one road
(all sem : Semaphore |
  (let rd = getSRoads[sem] | #rd=1)
)
}

//Semaphores of one intersection should display different colors
fact greenIsExclusive{
    all i : Intersection |
    ( let s = getSemaphores[i] | all s1: Semaphore, s2 : Semaphore | 
                                    (s1 in s and s2 in s and s1 != s2)
                                    implies s1.color != s2.color )
}

//Traffic flows with GREEN
fact goWithGreen{
    (all s: Semaphore | let r = getSRoads[s] | 
                        s.color=RED iff r.traffic=STOPPED)
and
(all r: Road | r.traffic=STOPPED implies
                #((Intersection.connection).r)>0)
}

pred show{
    #Intersection = 1
}

run show for 8