; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 1 Day 5

(ns solutions-4clojure.week-1.day-5
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/30
; Write a function which removes consecutive duplicates from a sequence.
(problem [_]
         (list
          (= (apply str (_ "Leeeeeerrroyyy")) "Leroy")
          (= (_ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
          (= (_ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))
         (fn [coll] (->> coll
                         (partition-by identity)
                         (map #(first %)))))

; http://www.4clojure.com/problem/31
; Write a function which packs consecutive duplicates into sub-lists.
(problem [_]
         (list
          (= (_ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
          (= (_ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
          (= (_ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
         #(partition-by identity %))

; http://www.4clojure.com/problem/41
; Write a function which drops every Nth item from a sequence.
(problem [_]
         (list
          (= (_ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
          (= (_ [:a :b :c :d :e :f] 2) [:a :c :e])
          (= (_ [1 2 3 4 5 6] 4) [1 2 3 5 6]))
         ; solution 1
         (fn [coll n]
           (let [collSize (count coll)
                 collZip (zipmap (range 1 (inc collSize)) coll)]
             (->> collZip
                  (filter (fn [pair]
                            (let [key (first pair)]
                              (not= (mod key n) 0))))
                  (map #(second %))
                  (into []))))
         ; solution 2
         (fn [coll n]
           (let [collSize (count coll)]
             (vec (for [index (range collSize)
                        :let [x (nth coll index)
                              i (inc index)]
                        :when (#(not= (mod i n) 0))]
                    x))))
         ; solution 3
         #(apply concat (partition-all (dec %2) %2 %)))

; http://www.4clojure.com/problem/45
; The iterate function can be used to produce an infinite lazy sequence.
(problem [_]
         (list
          (= _ (take 5 (iterate #(+ 3 %) 1))))
         [1 4 7 10 13])

; http://www.4clojure.com/problem/33
; Write a function which replicates each element of a sequence a variable
; number of times.
(problem [_]
         (list
          (= (_ [1 2 3] 2) '(1 1 2 2 3 3))
          (= (_ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
          (= (_ [4 5 6] 1) '(4 5 6))
          (= (_ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
          (= (_ [44 33] 2) [44 44 33 33]))
         #(apply concat (map (fn [x] (repeat %2 x)) %)))
