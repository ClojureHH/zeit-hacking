;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit ctrl+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns homeless-lagoon
  (:require [gorillalabs.config :as config]
            [clj-http.client :as client]
            [gorilla-plot.core :as plot]
            [cheshire.core :as json]
            ))

(def conf (config/init))


(println (:teaser_text (first (:matches (json/parse-string (:body (client/get "http://api.zeit.de/content"
  {:headers {"X-Authorization" (:api-key conf)}})) true)))))


;; @@
;; ->
;;; &quot;Harte Rechtsextremisten&quot; und &quot;neue Nazis&quot; – Politiker haben zum Jahrestag den Pegida-Anhängern Rassismus vorgeworfen. In Dresden sind mehrere Gegendemos angekündigt.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
