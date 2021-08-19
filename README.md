# Evaluation of Heuristics for Product Data Models

The provided code provides an implementation for the approaches presented and evaluated in the following paper:

Konstantinos Varvoutas, Anastasios Gounaris: Evaluation of Heuristics for Product Data Models. In: International Conference on Business Process Management, pp. 355–366, Springer 2020. (https://rd.springer.com/chapter/10.1007%2F978-3-030-66498-5_26)

The heuristics were evaluated using two different Product Data Models (PDMs), which were implemented seperately. The PBWS folder corresponds to a mortage PDM (fig. 1 of the paper), while the PBWD folder corresponds to a social insurance PDM (fig. 2 of the paper). Both PDMs have been implemented in the same manner.

How to execute the PDMs using the heuristics:

The execution requires no arguments. It is set by default to 100.000 instances.

For each heuristic it outputs the average cost and time of execution. Also, it saves the cost and time of execution of every instance to a (seperate) txt file for each heuristic. 
