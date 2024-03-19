package dev.jordond.compass.geocoder

import dev.jordond.compass.Location
import dev.jordond.compass.Place

/**
 * Wrapper for platform-specific geocoding services.
 */
public interface PlatformGeocoder {

    /**
     * Returns true if the geocoder is available on the current platform.
     *
     * On iOS this always returns `true.
     *
     * @return `true` if the geocoder is available, false otherwise.
     */
    public fun isAvailable(): Boolean

    /**
     *  Get a list of [Place]s from latitude and longitude coordinates.
     *
     * @param latitude The latitude of the coordinates.
     * @param longitude The longitude of the coordinates.
     * @return The address of the coordinates or empty list if the address could not be found.
     */
    public suspend fun placeFromLocation(latitude: Double, longitude: Double): List<Place>

    /**
     * Get a list of [Location]s from an address.
     */
    public suspend fun locationFromAddress(address: String): List<Location>

    public companion object
}