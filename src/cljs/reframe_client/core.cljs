(ns reframe-client.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [reframe-client.events]
            [reframe-client.views :as views]
            [reframe-client.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init-clock []
  (let [tick (fn [] (re-frame/dispatch [:tick]))]
    (.setInterval js/window tick 1000)))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root)
  (init-clock))
