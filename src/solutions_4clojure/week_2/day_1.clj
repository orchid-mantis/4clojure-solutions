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

; http://www.4clojure.com/problem/29
; Write a function which takes a string and returns a new string containing
; only the capital letters.
(problem [_]
         (list
          (= (_ "HeLlO, WoRlD!") "HLOWRD")
          (empty? (_ "nothing"))
          (= (_ "$#A(*&987Zf") "AZ"))
         ; solution 1
         #(apply str (re-seq #"[A-Z]+" %))
         ; solution 2
         #(let [input %
                upper? (fn [intCh]
                         (and (>= intCh (int \A)) (<= intCh (int \Z))))]
            (apply str (filter (fn [ch]
                                 (when (upper? (int ch)) ch)) input))))

; http://www.4clojure.com/problem/48
; The some function takes a predicate function and a collection.
; It returns the first logical true value of (predicate x) where x is an item
; in the collection.
(problem [_]
         (list
          (= _ (some #{2 7 6} [5 6 7 8]))
          (= _ (some #(when (even? %) %) [5 6 7 8])))
         6)

; http://www.4clojure.com/problem/42
; Write a function which calculates factorials.
(problem [_]
         (list
          (= (_ 1) 1)
          (= (_ 3) 6)
          (= (_ 5) 120)
          (= (_ 8) 40320))
         #(reduce * (range 1 (inc %))))

; http://www.4clojure.com/problem/52
; Let bindings and function parameter lists support destructuring.
(problem [_]
         (list
          ; inlined solution
          (= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e])))
         '()) ; solution [c e] can't be used in macro
