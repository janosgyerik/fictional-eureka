> Explain how you implemented the nearest insertion heuristic.

I add the points to a linked list.
If the list is empty, I simply append the point.
If the list is not empty, I find the closest point,
by checking the distance to every point in the list.
I insert the new point after the first closest point.

> Explain how you implemented the smallest insertion heuristic. It's sufficient to list only the differences between this heuristic and the nearest insertion heuristic.

I add the points to a linked list.
If the list has less than one element, I simply append the point.
If the list has at least two elements, I find the pair of points such that
inserting the new point in between them would cause the smallest increase in distance.
The increase in distance when inserting X between A and B is:
- dist(A, B) + dist(A, X) + dist(X, B).
I insert the new point in between the first pair with the smallest increase.

> Explain why it's better to use a circular linked list instead of an array.

If we used an array, then when inserting a point,
we would need to shift elements to the right of the insert position,
which is expensive.

> Do two timing analyses.
Estimate the running time (in seconds)  of each heuristic as a function of N,
using expressions of the form: a * N^b, where b is an integer.
Explain how you determined each of your answers.
To get your data points, run the two heuristics for N = 10000,
and repeatedly double N until the execution time exceeds 60 seconds.
You may use TSPTimer to help do this, as per the checklist.
(If N = 10000 takes over 60 seconds, your code is too slow.
See the checklist for a suggestion on how to fix it.)

Timing analysis:
For both algorithms: C * N * N. That is, in both algorithms,
adding a new point requires comparisons with the existing points.
For example, when there are 5 points and we add a 6th,
we make comparisons with the 5 existing points.
More generally, when adding the Nth point,
we make comparisons with the existing N-1 points.
Hence, the time cost is proportional to N * N,
and can be obtained by multiplying N * N with some constant C.

> also the tour.java you sent me did not pass the necessary tests ):

Please tell me what are those tests, so that I can answer that.
