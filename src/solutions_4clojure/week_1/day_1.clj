; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 1 Day 1

(ns solutions-4clojure.week-1.day-1
  (:require [solutions-4clojure.helper :refer [problem _]])
  (:require [clojure.set]))

; http://www.4clojure.com/problem/3
; Clojure strings are Java strings. This means that you can use any of the Java
; string methods on Clojure strings.
(problem [_]
         (list
          ; test case
          (= _ (.toUpperCase "hello world")))
         ; solution
         "HELLO WORLD")

; http://www.4clojure.com/problem/4
; Lists can be constructed with either a function or a quoted form.
(problem [_]
         (list
          ; inlined solution
          (= (list :a :b :c) '(:a :b :c)))
         true)

; http://www.4clojure.com/problem/5
; When operating on a list, the conj function will return a new list with one
; or more items "added" to the front.
;
; Note that there are two test cases, but you are expected to supply only one
; answer, which will cause all the tests to pass.
(problem [_]
         (list
          (= _ (conj '(2 3 4) 1))
          (= _ (conj '(3 4) 2 1)))
         '(1 2 3 4))

; http://www.4clojure.com/problem/6
; Vectors can be constructed several ways. You can compare them with lists.
;
; Note: the brackets [] surrounding the blanks _ are part of the test case.
(problem [_]
         (list
          ; inlined solution
          (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))
         true)

; http://www.4clojure.com/problem/7
; When operating on a Vector, the conj function will return a new vector with
; one or more items "added" to the end.
(problem [_]
         (list
          (= _ (conj [1 2 3] 4))
          (= _ (conj [1 2] 3 4)))
         [1 2 3 4])

; http://www.4clojure.com/problem/8
; Sets are collections of unique values.
(problem [_]
         (list
          (= _ (set '(:a :a :b :c :c :c :c :d :d)))
          (= _ (clojure.set/union #{:a :b :c} #{:b :c :d})))
         #{:a :b :c :d})

; http://www.4clojure.com/problem/9
; When operating on a set, the conj function returns a new set with one or more
; keys "added".
(problem [_]
         (list
          (= #{1 2 3 4} (conj #{1 4 3} _)))
         2)

; http://www.4clojure.com/problem/10
; Maps store key-value pairs. Both maps and keywords can be used as lookup
; functions. Commas can be used to make maps more readable, but they are not
; required.
(problem [_]
         (list
          (= _ ((hash-map :a 10, :b 20, :c 30) :b))
          (= _ (:b {:a 10, :b 20, :c 30})))
         20)

; http://www.4clojure.com/problem/11
; When operating on a map, the conj function returns a new map with one or more
; key-value pairs "added".
(problem [_]
         (list
          (= {:a 1, :b 2, :c 3} (conj {:a 1} _ [:c 3])))
         {:b 2})

; http://www.4clojure.com/problem/12
; All Clojure collections support sequencing. You can operate on sequences with
; functions like first, second, and last.
(problem [_]
         (list
          (= _ (first '(3 2 1)))
          (= _ (second [2 3 4]))
          (= _ (last (list 1 2 3))))
         3)
