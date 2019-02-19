(ns reframe-client.events
  (:require [re-frame.core :as re-frame]
            [reframe-client.db :as db]
            [cljs-time.core :as date-time]))


(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
    :new-input-task
  (fn [db [_ new-task-name]]
     (let [new-db (assoc db :elements (assoc (:elements db) (:counter db)
                                                            {:name new-task-name
                                                             :done false
                                                             :created (date-time/to-default-time-zone (date-time/now))}))]
       (assoc new-db :counter (inc (:counter new-db))))))

(re-frame/register-handler
  :remove-input-task
  (fn [db [_ id]]
    (assoc db :elements (dissoc (:elements db) id))))

(re-frame/register-handler
  :done-changed
  (fn [db [_ element-id value]]
    (assoc db :elements (assoc-in (:elements db) [element-id :done] value))))

(re-frame/register-handler
  :tick
  (fn [db _]
    (assoc db :time (date-time/to-default-time-zone (date-time/now)))))
