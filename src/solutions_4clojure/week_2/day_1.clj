; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 2 Day 1

(ns solutions-4clojure.week-2.day-1
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/26
; Write a function which returns the first X fibonacci numbers.
(problem [_]
         (list
          (= (_ 3) '(1 1 2))
          (= (_ 6) '(1 1 2 3 5 8))
          (= (_ 8) '(1 1 2 3 5 8 13 21)))
         ; solution 1
         (fn [n] (reverse (loop [len n
                                 result '(1 1)]
                            (cond
                              (< len 1) '()
                              (= len 1) '(1)
                              (= len 2) result
                              :else (let [[x y _] result]
                                      (recur (dec len) (conj result (+ x y))))))))
         ; solution 2
         #(map first (take % (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))
