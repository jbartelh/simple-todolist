(ns reframe-client.views
  (:require [re-frame.core :as re-frame]
            [reframe-client.subs :as subs]
            [reagent.core :as reagent]
            ))

(defn input []
  (let [input (reagent/atom "")
        on-click (fn [_]
                   (when-not (empty? @input)
                       (re-frame/dispatch [:new-input-task @input])))]
    (fn []
      [:div.input-group
       [:input.form-control {:type "text"
                             :placeholder "Enter new Task"
                             :on-change #(reset! input (-> % .-target .-value))
                             :on-key-press (fn [event]
                                             (if (= 13 (.-charCode  event))
                                               (on-click event)))}]
       [:span.input-group-btn
        [:button.btn.btn-default {:type "button"
                                  :on-click #(on-click %)}
         "Add"]]])))


(defn list-element [element]
  (let [element-value (get element 1)
        element-id (get element 0)
        remove-element (fn [_]
                         (re-frame/dispatch [:remove-input-task element-id]))
        done-changed (fn [_ state]
                       (re-frame/dispatch [:done-changed element-id state]))]
    [ :li.list-group-item
     [:div.d-flex
      [:div.p-2
       [:input {:type "checkbox"
                :checked (:done element-value)
                :on-change #(done-changed % (-> % .-target .-checked))}]]
      [:div.p-2.flex-fill
       [:small (:name element-value)]]
      [:div.p-2
       [:small (:created element-value)]]
      [:div.p-2
       [:button.btn.btn-secondary {:type "button"
                                   :on-click #(remove-element %)} "remove"]]]]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        elements (re-frame/subscribe [::subs/elements])]
    [:div
     [:div.topbar [:div.container
                   [:div.row "Hello from " @name]
                   [:div.row [:div [input]]]]]
     [:div.main-content
      [:div.container
       [:div.row
        [:div.col-10.col-sm-10
         [:ul.list-group
          (map(fn [element]
                         (list-element element))
                       @elements)]]]]]]))

