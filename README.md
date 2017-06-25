Quake Report App
===================================

This app displays a list of recent earthquakes in the world
from the U.S. Geological Survey (USGS) organization.

Used in a Udacity course in the Beginning Android Nanodegree.

More info on the USGS Earthquake API available at:
http://earthquake.usgs.gov/fdsnws/event/1/

The app uses a network connection in an AsyncTaskLoader to download its data in an background task.
It also uses an "empty list view" to show an alternative view when the result list is empty for any reason.
It uses a ProgressBar spinner view to show the network activity is ongoing if it takes longer to download the data.
It detects whether an internet connection is available or not. If not, an alternative TextView is shown which tells the state.

Screenshots
-----------

<img src="https://dl.dropboxusercontent.com/s/5e1wnjvc13m4xly/Screenshot_1498413373.png" alt="" width=200/> <img src="https://dl.dropboxusercontent.com/s/0kvm85wkmd7bcpu/Screenshot_1498413551.png" alt="" width=200/> <img src="https://dl.dropboxusercontent.com/s/3lxu8sduo690ubu/Screenshot_1498413616.png" alt="" width=200/> <img src="https://dl.dropboxusercontent.com/s/o8wc0a9r26lzr4v/Screenshot_1498413689.png" alt="" width=200/>

Pre-requisites
--------------

- Android SDK v23
- Android Build Tools v23.0.2
- Android Support Repository v23.3.0

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Google+ Community: https://plus.google.com/communities/105153134372062985968
- Stack Overflow: http://stackoverflow.com/questions/tagged/android

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub. Please see CONTRIBUTING.md for more details.

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
