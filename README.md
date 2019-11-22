# DevFest 2019 Kathmandu. Demo Application
## Espresso UI Testing

> This repository is for an App (if you would call this one) to demonstrate UI Testing on Android using Espresso.

The app has a single screen which acts as Login Screen. 

The Espresso tests are located on the `app/src/androidTest/java/com/ravigarbuja/devfest2019/` directory.

Before running Espresso tests:
- Turn off the following in your device's Developer Options 
  - Window Animation Scale
  - Transition Animation Scale
  - Animator Duration Scale
- Turn off AutoFill Service from the Settings too.
  (you can do the same from CLI, using `adb shell settings put secure autofill_service null` )

**Do turn back to defaults after testing**

> Please do not take the actual validation logic in `app/src/main/java/com/devfest2019/MainActivity.kt` for your inspiration. The code was written in just a few minutes to demonstrate Espresso UI Tests
