; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 3 Day 4

(ns solutions-4clojure.week-3.day-4
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/67
; Write a function which returns the first x number of prime numbers.
(problem [_]
         (list
          (= (_ 2) [2 3])
          (= (_ 5) [2 3 5 7 11])
          (= (last (_ 100)) 541)
          )
         (fn prime-numbers [n]
           (->> (range 2 1000)
                (iterate (fn remove-multiples [coll]
                           (remove
                            #(= 0 (mod % (first coll)))
                            coll)))
                (take n)
                (map first))))
