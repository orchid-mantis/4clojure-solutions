; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/
;
; Week 3 Day 5

(ns solutions-4clojure.week-3.day-5
  (:require [solutions-4clojure.helper :refer [problem _]]))

; http://www.4clojure.com/problem/77
; Write a function which finds all the anagrams in a vector of words.
; A word x is an anagram of word y if all the letters in x can be rearranged
; in a different order to form y. Your function should return a set of sets,
; where each sub-set is a group of words which are anagrams of each other.
; Each sub-set should have at least two words. Words without any anagrams
; should not be included in the result.
(problem [_]
         (list
          (= (_ ["meat" "mat" "team" "mate" "eat"])
             #{#{"meat" "team" "mate"}})
          (= (_ ["veer" "lake" "item" "kale" "mite" "ever"])
             #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))
         (fn anagrams [coll]
           (->> coll
                (group-by #(set (partition-all 1 %)))
                (vals)
                (filter #(> (count %) 1))
                (map set)
                (set))))
