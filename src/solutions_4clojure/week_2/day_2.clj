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
