(ns app.state.effects.navigation.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :active-nav
 (fn [db _]
   (get-in db [:nav :active-nav])))
