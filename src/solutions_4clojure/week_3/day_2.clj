; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 3 Day 2

(ns solutions-4clojure.week-3.day-2
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/46
; Write a higher-order function which flips the order of the arguments of an input function.
(problem [_]
         (list
          (= 3 ((_ nth) 2 [1 2 3 4 5]))
          (= true ((_ >) 7 8))
          (= 4 ((_ quot) 2 8))
          (= [1 2 3] ((_ take) [1 2 3 4 5] 3)))
         (fn [f] 
           (fn [a b]
             (f b a))))
