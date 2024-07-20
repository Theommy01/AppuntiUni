/*
Observe the following figure. It describes a communication system composed of an 
overlay network linking nodes A and E. This overlay is a virtual network built on top of an underlay network. In the figure, the underlay network is composed of four nodes (a, b, d, 
and e) and link L exploits the links between a, b, d and e in the underlay network to 
ensure that A and E can communicate

Consider the following Alloy signatures:
*/

sig Network {
uses: lone Network
}{ this not in uses }
sig Node {
belongsTo: Network,
isLinkedTo: some Node,
isAttachedTo: lone Node
}{ this not in isAttachedTo and
this not in isLinkedTo }

/*
Explain the meaning of these signatures with respect to the figure above and indicate which elements in the figure are not explicitly modeled by the two 
signatures

Write facts to model the following constraints
- Linked nodes have to be in the same network
- A node belonging to a certain network can only be attached to nodes of the corresponding 
underlay network
- If a network is an overlay one, then there should not be nodes in this network that are not 
attached to other nodes
- A network should always contain some nodes

Write the predicate isReachable that, given a pair of Nodes, n1 and n2, is 
true if there exists a path that from n2 reaches n1, possibly passing through
any intermediate node
*/


sig Network {
    uses: lone Network
}{ this not in uses }

sig Node {
    belongsTo: Network,
    isLinkedTo: some Node,
    isAttachedTo: lone Node
}{ this not in isAttachedTo and
   this not in isLinkedTo }

//Linked nodes have to be in the same network
fact linkedNodesInTheSameNetwork {
    all disj n1, n2: Node | 
        n1 in n2.isLinkedTo implies
            #(n1.belongsTo & n2.belongsTo) > 0
}

// A node belonging to a certain network can only be
// attached to nodes of the corresponding underlay network
fact isAttachedToInConnectedNetworks {
    all disj n1, n2: Node | 
             n1 in n2.isAttachedTo implies
                    #(n1.belongsTo & n2.belongsTo.uses) > 0
}


// If a network is an overlay one, then there should not be nodes in
// this network that are not attached to other nodes
fact overlayNodeShouldBeAttached {
    all ntw: Network | 
        some ntw2: Network | ntw2 in ntw.uses
          implies
        all n: Node | n.belongsTo = ntw implies n.isAttachedTo != none
}

// A network should always contain some nodes
fact notEmptyNetwork {
    all ntw: Network | some n: Node | n.belongsTo = ntw
}

// Linked nodes have to be in the same network
fact linkedNodesInTheSameNetwork {
    all disj n1, n2: Node | 
             n1 in n2.isLinkedTo implies n1.belongsTo = n2.belongsTo
}

// A node belonging to a certain network can only be
// attached to nodes of the corresponding underlay network
fact isAttachedToInConnectedNetworks {
    all disj n1, n2: Node | 
             n1 in n2.isAttachedTo implies
                                    n1.belongsTo in n2.belongsTo.uses
}

// If a network is an overlay one, then there should not be nodes in
// this network that are not attached to other nodes
fact overlayNodeShouldBeAttached {
    all ntw: Network | 
    some ntw2: Network | ntw2 in ntw.uses implies
        all n: Node | n.belongsTo = ntw implies n.isAttachedTo != none
}

// A network should always contain some nodes
fact notEmptyNetwork {
    all ntw: Network | some n: Node | n.belongsTo = ntw
}

//n1 is reachable from n2
pred isReachable[n1: Node, n2: Node] {
    n1 in n2.^isLinkedTo
}