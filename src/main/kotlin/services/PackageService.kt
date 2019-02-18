package services

import dao.PackageDao
import models.File
import models.Package

class PackageService(userID: Int, password: String) : Service<Package>() {

    private val packageDao: PackageDao = PackageDao(userID, password)

    override fun find(id: Int): Package? {
        return packageDao.findById(id)
    }

    override fun save(obj: Package) {
        packageDao.save(obj)
    }

    override fun update(obj: Package) {
        packageDao.update(obj)
    }

    override fun delete(obj: Package) {
        packageDao.delete(obj)
    }

    fun findFileById(id: Int): File {
        return packageDao.findFileById(id)
    }

    override fun getAll(): List<Package> {
        val all = packageDao.all
        all.drop(1)
        return all
    }
}