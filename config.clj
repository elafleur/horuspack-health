(ns pack.health.config
  "General CPU, memory, disk and load monitoring."
  (:require [riemann.config :refer :all]
            [riemann.streams :refer :all]
            [core.alert.config :refer [alert]]
            [core.engine.config :refer [time-series]]))

(let [index (index)]
  (streams
    ; package namespace tag
    (where (tagged "#health")

      ; time-series of memory usage %
      (match :service "memory"
        (changed-state {:init "ok"}
          (where (state "critical")
            (alert :level "severe"))
          (where (state "warning")
            (alert :level "moderate"))
          (where (state "ok")
            (alert :level "minor")))
        (scale 100
          (time-series :groupby "host"))
        index))))

