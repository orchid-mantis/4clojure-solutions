; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 2 Day 2

(ns solutions-4clojure.week-2.day-2
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/51
; Here is an example of some more sophisticated destructuring.
(problem [_]
         (list
          (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] _] [a b c d])))
         [1 2 3 4 5])

; http://www.4clojure.com/problem/83
; Write a function which takes a variable number of booleans.
; Your function should return true if some of the parameters are true,
; but not all of the parameters are true. Otherwise your function should return false.
(problem [_]
         (list
          (= false (_ false false))
          (= true (_ true false))
          (= false (_ true))
          (= true (_ false true false))
          (= false (_ true true true))
          (= true (_ true true true false)))
         (fn [& bools]
           (let [someTrue (not (nil? (some true? bools)))
                 allTrue (every? true? bools)]
             (and someTrue (not allTrue)))))

; http://www.4clojure.com/problem/66
; Given two integers, write a function which returns the greatest common divisor.
(problem [_]
         (list
          (= (_ 2 4) 2)
          (= (_ 10 5) 5)
          (= (_ 5 7) 1)
          (= (_ 1023 858) 33))
         (fn [x y]
           (loop [u x
                  w y]
             (if (= w 0)
               u
               (recur w (mod u w))))))
