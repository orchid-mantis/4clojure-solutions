; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/

; https://github.com/tantaman/4clojure-solutions
; Macro for running problems & solutions against their test cases.
; @author Tantaman
(defmacro problem [probArgs probBody & solList]
  `(assert (= 0 (count (filter false? (map
                                       (fn ~probArgs (and true ~@probBody)) (list ~@solList)))))))

(def _)

; ===========| Day 3 |===========

; http://www.4clojure.com/problem/37
; Regex patterns are supported with a special reader macro.
(problem [_]
         (list
          (= _ (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))
         "ABC")

; http://www.4clojure.com/problem/57
; A recursive function is a function which calls itself.
; This is one of the fundamental techniques used in functional programming.
(problem [_]
         (list
          (= _ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))
         '(5 4 3 2 1))

; http://www.4clojure.com/problem/68
; Clojure only has one non-stack-consuming looping construct: recur. Either a function
; or a loop can be used as the recursion point. Either way, recur rebinds the bindings
; of the recursion point to the values it is passed.
; Recur must be called from the tail-position, and calling it elsewhere will result in
; an error.
(problem [_]
         (list
          (= _
             (loop [x 5
                    result []]
               (if (> x 0)
                 (recur (dec x) (conj result (+ 2 x)))
                 result))))
         [7 6 5 4 3])

; http://www.4clojure.com/problem/71
; The -> macro threads an expression x through a variable number of forms.
; First, x is inserted as the second item in the first form, making a list of it
; if it is not a list already. Then the first form is inserted as the second item
; in the second form, making a list of that form if necessary.
; This process continues for all the forms. Using -> can sometimes make your code more
; readable.
(problem [_]
         (list
          (= (_ (sort (rest (reverse [2 5 4 1 3 6]))))
             (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (_))
             5))
         last)

; http://www.4clojure.com/problem/72
; The ->> macro threads an expression x through a variable number of forms.
; First, x is inserted as the last item in the first form, making a list of it
; if it is not a list already. Then the first form is inserted as the last item in
; the second form, making a list of that form if necessary. This process continues for
; all the forms. Using ->> can sometimes make your code more readable.
(problem [_]
         (list
          (= (_ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
             (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (_))
             11))
         #(reduce + %)) ; macro can't handle solution "reduce +"

; http://www.4clojure.com/problem/145
; Clojure's for macro is a tremendously versatile mechanism for producing a sequence
; based on some other sequence (s). It can take some time to understand how to use it
; properly, but that investment will be paid back with clear, concise sequence-wrangling
; later. With that in mind, read over these for expressions and try to see how
; each of them produces the same result.
(problem [_]
         (list
          (= _ (for [x (range 40)
                      :when (= 1 (rem x 4))]
                  x))
          (= _ (for [x (iterate #(+ 4 %) 0)
                      :let [z (inc x)]
                      :while (< z 40)]
                  z))
          (= _ (for [[x y] (partition 2 (range 20))]
                  (+ x y))))
         '(1 5 9 13 17 21 25 29 33 37))

; ===========| Day 4 |===========

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

; ===========| Day 5 |===========
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
                  (into [])
                  )))
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
