; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 2 Day 4

(ns solutions-4clojure.week-2.day-4
  (:require [solutions-4clojure.helper :refer [problem _]])
  (:require [clojure.set]))

; http://www.4clojure.com/problem/88
; Write a function which returns the symmetric difference of two sets.
; The symmetric difference is the set of items belonging to one
; but not both of the two sets.
(problem [_]
         (list
          (= (_ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
          (= (_ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
          (= (_ #{} #{4 5 6}) #{4 5 6})
          (= (_ #{} #{4 5 6}) #{4 5 6}))
         (fn [s1 s2] (let [unioned (clojure.set/union s1 s2)
                           intersected (clojure.set/intersection s1 s2)]
                     (clojure.set/difference unioned intersected))))

; http://www.4clojure.com/problem/100
; Write a function which calculates the least common multiple.
; Your function should accept a variable number of positive integers or ratios.
; lcm(a, b) = a*b / gcd(a, b)
(problem [_]
         (list
          (== (_ 2 3) 6)
          (== (_ 5 3 7) 105)
          (== (_ 1/3 2/5) 2)
          (== (_ 3/4 1/6) 3/2)
          (== (_ 7 5/7 2 3/5) 210)
          )
         (fn [& numbers]
           (let [gcd (fn [x y] (loop [u x
                                      w y]
                                 (if (= w 0)
                                   u
                                   (recur w (mod u w)))))
                 lcm (fn [x y] (/ (* x y) (gcd x y)))]
             (reduce lcm numbers))))
