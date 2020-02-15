; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 3 Day 1

(ns solutions-4clojure.week-3.day-1
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/95
; Write a predicate which checks whether or not a given sequence represents
; a binary tree. Each node in the tree must have a value, a left child, and
; a right child.
(problem [_]
         (list
          (= (_ '(:a (:b nil nil) nil))
             true)
          (= (_ '(:a (:b nil nil)))
             false)
          (= (_ [1 nil [2 [3 nil nil] [4 nil nil]]])
             true)
          (= (_ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
             false)
          (= (_ [1 [2 [3 [4 nil nil] nil] nil] nil])
             true)
          (= (_ [1 [2 [3 [4 false nil] nil] nil] nil])
             false)
          (= (_ '(:a nil ()))
             false))
           (fn binary-tree? [tree]
             (cond
               (nil? tree) true ; leaf node
               (not (coll? tree)) false
               :else (let [[value lChild rChild & _ :as node] tree
                           has-value? (or (number? value) (keyword? value))
                           three-parts? (= (count node) 3)
                           valid-node? (and has-value? three-parts?)]
                       (cond
                         (not valid-node?) false
                         :else (and (binary-tree? lChild)
                                    (binary-tree? rChild)))))))
