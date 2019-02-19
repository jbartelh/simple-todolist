(ns reframe-client.db
  (:require [cljs-time.core :as date-time]))

(def default-db
  {:name "re-frame"
   :elements (hash-map)
   :counter 0
   :time (date-time/to-default-time-zone (date-time/now))}
  )
