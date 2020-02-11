; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 2 Day 3

(ns solutions-4clojure.week-2.day-3
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/107
; Lexical scope and first-class functions are two of the most basic building
; blocks of a functional language like Clojure. When you combine the two
; together, you get something very powerful called lexical closures. With these,
; you can exercise a great deal of control over the lifetime of your local
; bindings, saving their values for use later, long after the code you're
; running now has finished.

; It can be hard to follow in the abstract, so let's build a simple closure.
; Given a positive integer n, return a function (f x) which computes x n.
; Observe that the effect of this is to preserve the value of n for use outside
; the scope in which it is defined.
(problem [_]
         (list
          (= 256 ((_ 2) 16) ((_ 8) 2))
          (= [1 8 27 64] (map (_ 3) [1 2 3 4]))
          (= [1 2 4 8 16] (map #((_ %) 2) [0 1 2 3 4])))
         (fn [n] (comp (partial reduce *) (partial repeat n))))
