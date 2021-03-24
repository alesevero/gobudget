(ns app.state.effects.navigation.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 :set-active-nav
 (fn [db [_ active-nav]]
   (assoc-in db [:nav :active-nav] active-nav)))
