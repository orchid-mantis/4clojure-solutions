; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Day 4

(ns solutions-4clojure.problems
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/20
; Write a function which returns the second to last element from a sequence. 
(problem [_]
         (list
          (= (_ (list 1 2 3 4 5)) 4)
          (= (_ ["a" "b" "c"]) "b")
          (= (_ [[1 2] [3 4]]) [1 2]))
         #(second (reverse %)))

; http://www.4clojure.com/problem/24
; Write a function which returns the sum of a sequence of numbers. 
(problem [_]
         (list
          (= (_ [1 2 3]) 6)
          (= (_ (list 0 -2 5 5)) 8)
          (= (_ #{4 2 1}) 7)
          (= (_ '(0 0 -1)) -1)
          (= (_ '(1 10 3)) 14))
         #(reduce + %))

; http://www.4clojure.com/problem/25
; Write a function which returns only the odd numbers from a sequence.
(problem [_]
         (list
          (= (_ #{1 2 3 4 5}) '(1 3 5))
          (= (_ [4 2 1 6]) '(1))
          (= (_ [2 2 4 6]) '())
          (= (_ [1 1 1 3]) '(1 1 1 3)))
         #(filter odd? %))

; http://www.4clojure.com/problem/27
; Write a function which returns true if the given sequence is a palindrome.
; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(problem [_]
         (list
          (false? (_ '(1 2 3 4 5)))
          (true? (_ "racecar"))
          (true? (_ [:foo :bar :foo]))
          (true? (_ '(1 1 3 3 1 1)))
          (false? (_ '(:a :b :c))))
         #(= (apply str %) (apply str (reverse %))))

; http://www.4clojure.com/problem/32
; Write a function which duplicates each element of a sequence.
(problem [_]
         (list
          (= (_ [1 2 3]) '(1 1 2 2 3 3))
          (= (_ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
          (= (_ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
          (= (_ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
         #(apply concat (map list % %)))
