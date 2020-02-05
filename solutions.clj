
; Solutions to 4clojure problems from Living Clojure book
; http://www.4clojure.com/

; https://github.com/tantaman/4clojure-solutions
; Macro for running problems & solutions against their test cases.
; @author Tantaman
(defmacro problem [probArgs probBody & solList]
  `(assert (= 0 (count (filter false? (map
                                       (fn ~probArgs (and true ~@probBody)) (list ~@solList)))))))

(def _)

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
