# cocoapods-acknowledgements-licenses

[![Clojars Version](https://img.shields.io/clojars/v/org.clojars.vrs/cocoapods-acknowledgements-licenses)](https://clojars.org/org.clojars.vrs/cocoapods-acknowledgements-licenses)

A Clojure library for parsing [CocoaPods
Acknowledgements](https://github.com/CocoaPods/cocoapods-acknowledgements)
`plist` files to be used in
[pip-license-checker](https://github.com/pilosus/pip-license-checker)
license compliance tool.

## Installation

### Leiningen

Add the following to the `:dependencies` list in your `project.clj`:

```
[org.clojars.vrs/cocoapods-acknowledgements-licenses "0.1.0"]
```

## Quick Start

```
(require '[cocoapods-acknowledgements-licenses.core :refer [plist->data]])
(plist->data "resources/deps.plist" {:skip-header true :skip-footer true})
```


## Options

As a second argument `plist->data` expectes an options map. The
following options are availabe:

- `:skip-header [boolean]` - skip the first item in the plist file (header). Default value is `true`.
- `:skip-footer [boolean]` - skip the last item in the plist file (footer). Default value is `true`.


## License

Copyright © 2021 Vitaly Samigullin

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
