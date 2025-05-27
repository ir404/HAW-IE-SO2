## Summary of the Key Things 
### Scaling
1. Each and every class under the `rooster` package was adjusted so that they can be scaled using the `size` passed to `Rooster` when an object is instantiated
2. The dimensional properties (width, height, diameter, etc) and offsets in each part class were set relative to the coordinates passed to the `Rooster`. Adjust these properties with care. 
3. A new property called  `size` was introduced to each class under `rooster` to scale the object.
	1. During implementation a size of 1 of a Rooster was set to take up 200 x 200 px.

### Collision Detection & Drawing Multiple Roosters
1. The `Rooster` class implements the given interface `LocatedRectangle` and has been updated to include the method signatures.
	1. The coordinates of the rooster is now passed as a `Point(x, y)` variable  to the constructor instead of to the `drawAt(int left, int bottom)` method.
2. A `Scene` was added to the package `drawingTool`. The `Scene` contains an ArrayList `roosters` to store multiple roosters. 
3. Inside the `Scene` constructor,
	1. In a `for` loop we randomly generate x and y coordinates within the range of the application's width and height.
	2. A temporary `newRooster` is instantiated with these coordinates.
	3. If it's the first rooster in the loop then it's added to the ArrayList `roosters`
	4. Otherwise, we repeatedly check if it intersects/collides with any of the existing rooster objects stored in `roosters`.
		1. Only if `newRooster` had not intersected with any is it then added to the `roosters` ArrayList.
	5. The `for` loop runs 1000 times in order to generate (hopefully) enough roosters to fill the app's space. 
4. To draw the roosters stored in ArrayList `roosters` the `drawRoosters()` method is called which simply loops through every object in `roosters` and calls its `draw()` method.
