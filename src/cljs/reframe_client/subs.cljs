(ns reframe-client.subs
  (:require [re-frame.core :as re-frame]
            [cljs-time.core :as date-time]))

(re-frame/reg-sub
  ::name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
  ::elements
  (fn [db]
    (:elements db)))

(re-frame/reg-sub
  ::time
  (fn [db]
    (:time db)))

(re-frame/reg-sub
  ::time-diff
  (fn [db [_ start-time]]
    (let [time (:time db)]
      (if (<= start-time time)
        (date-time/in-minutes (date-time/interval start-time (:time db)))
        0))))
