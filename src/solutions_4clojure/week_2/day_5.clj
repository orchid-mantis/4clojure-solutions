; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 2 Day 5

(ns solutions-4clojure.week-2.day-5
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/97
; Pascal's triangle is a triangle of numbers computed using the following rules:
; - The first row is 1.
; - Each successive row is computed by adding together adjacent numbers in the
;   row above, and adding a 1 to the beginning and end of the row.
;
; Write a function which returns the nth row of Pascal's Triangle.
(problem [_]
         (list
          (= (_ 1) [1])
          (= (map _ (range 1 6))
             [[1]
              [1 1]
              [1 2 1]
              [1 3 3 1]
              [1 4 6 4 1]])
          (= (_ 11)
             [1 10 45 120 210 252 210 120 45 10 1]))
         ; solution 1
         (fn [row]
           (loop [n row
                  result '(1)]
             (if (= n 1)
               (vec result)
               (recur (dec n) (let [nextRow (->> result
                                                 (partition 2 1)
                                                 (map (partial apply +)))]
                                (concat '(1) nextRow '(1)))))))
         ; solution 2
         #(->> (iterate (fn [x] (let [nextRow (->> x
                                                  (partition 2 1)
                                                  (map (partial apply +)))]
                                 (concat '(1) nextRow '(1)))) '(1))
              (take %)
              (last)))
