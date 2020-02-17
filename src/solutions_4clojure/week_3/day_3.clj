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

; http://www.4clojure.com/problem/50
; Write a function which takes a sequence consisting of items with different
; types and splits them up into a set of homogeneous sub-sequences.
; The internal order of each sub-sequence should be maintained,
; but the sub-sequences themselves can be returned in any order
; (this is why 'set' is used in the test cases).
(problem [_]
         (list
          (= (set (_ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
          (= (set (_ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
          (= (set (_ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))
         (fn split-by-type [coll]
           (map second (group-by type coll))))
