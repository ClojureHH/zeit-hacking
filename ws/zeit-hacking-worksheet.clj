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
            [org.httpkit.client :as http]
            [gorilla-plot.core :as plot]
            [cheshire.core :as json]
            ))

(def conf (config/init))


(def options {:timeout 6000             ; ms
              :query-params {:q "Elbphilharmonie",
                             :sort "release_date desc, uuid desc",
                             :facet_field "keyword",
                             ; :facet_date ["1month", "1year"]
                             }
              :user-agent "ClojureMeetupHH-Test"
              :headers {"X-Authorization" (:api-key conf)}})


;(println (:teaser_text (first (:matches (json/parse-string (:body ...

(defn process [{:keys [status headers body error opts]}]
  (let [keywords-and-counts (apply hash-map (:keyword (:facets (json/parse-string body true))))
        keywords (take 10 (keys keywords-and-counts))
        counts (take 10 (vals keywords-and-counts))
        ]
    (println keywords)
    (println counts)
  	(plot/bar-chart keywords counts)
    ))

(let [response (http/get "http://api.zeit.de/content"
          options)]
  (process @response)
  )
;; @@
;; ->
;;; (bundesrat justizbehoerde corny-littmann bonn weizen klassik daenemark frankfurt-am-main fluechtling dresden)
;;; (1 1 1 2 1 1 1 1 4 1)
;;; 
;; <-
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2187957763672,"padding":{"top":10,"left":50,"bottom":20,"right":10},"data":[{"name":"5ab09b52-fd81-4aee-820d-c44ef550e087","values":[{"x":"bundesrat","y":1},{"x":"justizbehoerde","y":1},{"x":"corny-littmann","y":1},{"x":"bonn","y":2},{"x":"weizen","y":1},{"x":"klassik","y":1},{"x":"daenemark","y":1},{"x":"frankfurt-am-main","y":1},{"x":"fluechtling","y":4},{"x":"dresden","y":1}]}],"marks":[{"type":"rect","from":{"data":"5ab09b52-fd81-4aee-820d-c44ef550e087"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"width":{"scale":"x","band":true,"offset":-1},"y":{"scale":"y","field":"data.y"},"y2":{"scale":"y","value":0}},"update":{"fill":{"value":"steelblue"},"opacity":{"value":1}},"hover":{"fill":{"value":"#FF29D2"}}}}],"scales":[{"name":"x","type":"ordinal","range":"width","domain":{"data":"5ab09b52-fd81-4aee-820d-c44ef550e087","field":"data.x"}},{"name":"y","range":"height","nice":true,"domain":{"data":"5ab09b52-fd81-4aee-820d-c44ef550e087","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 50, :bottom 20, :right 10}, :data [{:name \"5ab09b52-fd81-4aee-820d-c44ef550e087\", :values ({:x \"bundesrat\", :y 1} {:x \"justizbehoerde\", :y 1} {:x \"corny-littmann\", :y 1} {:x \"bonn\", :y 2} {:x \"weizen\", :y 1} {:x \"klassik\", :y 1} {:x \"daenemark\", :y 1} {:x \"frankfurt-am-main\", :y 1} {:x \"fluechtling\", :y 4} {:x \"dresden\", :y 1})}], :marks [{:type \"rect\", :from {:data \"5ab09b52-fd81-4aee-820d-c44ef550e087\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :width {:scale \"x\", :band true, :offset -1}, :y {:scale \"y\", :field \"data.y\"}, :y2 {:scale \"y\", :value 0}}, :update {:fill {:value \"steelblue\"}, :opacity {:value 1}}, :hover {:fill {:value \"#FF29D2\"}}}}], :scales [{:name \"x\", :type \"ordinal\", :range \"width\", :domain {:data \"5ab09b52-fd81-4aee-820d-c44ef550e087\", :field \"data.x\"}} {:name \"y\", :range \"height\", :nice true, :domain {:data \"5ab09b52-fd81-4aee-820d-c44ef550e087\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}"}
;; <=

;; @@

;; @@

;; @@

;; @@
