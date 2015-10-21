(ns zeit-hacking.renderer
  (:require [gorilla-renderable.core :as render]))

;; The wrapper type for the renderer
(defrecord ContentView [content])

;; this view function renders the content
(defn content-view [c] (ContentView. c))

(extend-type ContentView
  render/Renderable
  (render [self]
    {:type    :html
     :content (format "<h3>%1$s<h3/>%2$s" (:title (:content self)) (:snippet (:content self)))
     :value   (pr-str self)}
    ))
