package com.madonnaapps.buswatch.cache.datastore

import com.madonnaapps.buswatch.cache.dao.LastLocationDao
import com.madonnaapps.buswatch.cache.mapper.CacheMapper
import com.madonnaapps.buswatch.cache.model.LastLocationDbo
import com.madonnaapps.buswatch.data.datastore.location.LocationLocalDataStore
import com.madonnaapps.buswatch.domain.model.LocationZoom
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocationLocalDataStoreImpl @Inject constructor(
    private val lastLocationDao: LastLocationDao,
    private val lastLocationMapper: CacheMapper<LastLocationDbo, LocationZoom>
) : LocationLocalDataStore {

    override fun getLastLocation(): Single<LocationZoom> {
        return lastLocationDao.getLastLocation()
            .map { lastLocationMapper.mapFromCacheObject(it) }
    }

    override fun saveLastLocation(locationZoom: LocationZoom): Completable {
        return lastLocationDao.insertLastLocation(
            lastLocationDbo = lastLocationMapper.mapToCacheObject(locationZoom)
        )
    }

}