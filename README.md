# health horus package
[![horusable](https://cdn.rawgit.com/crambit/horus/master/public/badges/horusable.svg)](https://github.com/crambit/horus)

General CPU, memory, disk and load monitoring.

## Producer

Source: https://github.com/riemann/riemann-tools

``` bash
gem install riemann-tools
riemann-health --host my.riemann.server --tag '#health'
```

If you want to use a different tag, please make sure to also modify the namespace tag in the configuration so that both match.

## Metrics

See [services](https://github.com/elafleur/horuspack-health/blob/master/services) for a list of event services exported by the producer.

## License

Copyright (c) 2016 Eric Lafleur

Distributed under the Eclipse Public License, the same as Clojure.
