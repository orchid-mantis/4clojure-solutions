; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 1 Day 2

(ns solutions-4clojure.week-1.day-2
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/13
; The rest function will return all the items of a sequence except the first.
(problem [_]
         (list
          (= _ (rest [10 20 30 40])))
         [20 30 40])

; http://www.4clojure.com/problem/14
; Clojure has many different ways to create functions.
(problem [_]
         (list
          (= _ ((fn add-five [x] (+ x 5)) 3))
          (= _ ((fn [x] (+ x 5)) 3))
          (= _ (#(+ % 5) 3))
          (= _ ((partial + 5) 3)))
         8)

; http://www.4clojure.com/problem/15
; Write a function which doubles a number.
(problem [_]
         (list
          (= (_ 2) 4)
          (= (_ 3) 6)
          (= (_ 11) 22)
          (= (_ 11) 22))
         #(* % 2))

; http://www.4clojure.com/problem/16
; Write a function which returns a personalized greeting.
(problem [_]
         (list
          (= (_ "Dave") "Hello, Dave!")
          (= (_ "Jenn") "Hello, Jenn!")
          (= (_ "Rhea") "Hello, Rhea!"))
         #(str "Hello, " % "!"))

; http://www.4clojure.com/problem/17
; The map function takes two arguments: a function (f) and a sequence (s).
; Map returns a new sequence consisting of the result of applying f to each
; item of s. Do not confuse the map function with the map data structure.
(problem [_]
         (list
          (= _ (map #(+ % 5) '(1 2 3))))
         '(6 7 8))

; http://www.4clojure.com/problem/18
; The filter function takes two arguments: a predicate function (f)
; and a sequence (s). Filter returns a new sequence consisting of all the items
; of s for which (f item) returns true.
(problem [_]
         (list
          (= _ (filter #(> % 5) '(3 4 5 6 7))))
         '(6 7))

; http://www.4clojure.com/problem/35
; Clojure lets you give local names to values using the special let-form.
(problem [_]
         (list
          (= _ (let [x 5] (+ 2 x)))
          (= _ (let [x 3, y 10] (- y x)))
          (= _ (let [x 21] (let [y 3] (/ x y)))))
         7)

; http://www.4clojure.com/problem/36
; Can you bind x, y, and z so that these are all true?
(problem [_]
         (list
          ; inlined solution
          (= 10 (let [x 7 y 3 z 1] (+ x y)))
          (= 4 (let [x 7 y 3 z 1] (+ y z)))
          (= 1 (let [x 7 y 3 z 1] z)))
         true)
