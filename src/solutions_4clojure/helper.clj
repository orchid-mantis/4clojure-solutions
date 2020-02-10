(ns solutions-4clojure.helper)

; https://github.com/tantaman/4clojure-solutions
; Macro for running problems & solutions against their test cases.
; @author Tantaman
(defmacro problem [probArgs probBody & solList]
  `(assert (= 0 (count (filter false? (map
                                       (fn ~probArgs (and true ~@probBody)) (list ~@solList)))))))

(def _)