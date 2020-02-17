; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 3 Day 3

(ns solutions-4clojure.week-3.day-3
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/43
; Write a function which reverses the interleave process into x number of subsequences.
(problem [_]
         (list
          (= (_ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
          (= (_ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
          (= (_ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))
         (fn reverse-interleave [coll n]
           (apply map list (partition n coll))))
