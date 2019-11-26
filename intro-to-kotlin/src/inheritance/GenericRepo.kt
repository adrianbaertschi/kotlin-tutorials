package inheritance

class GenericRepo<T> : RepoIntf<T> {
    override fun getByIid(id: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface RepoV2 {
    fun <T> getById(int: Int): T
    fun <T> getAll(): List<T>
}

class RepoImplV2 : RepoV2 {
    override fun <T> getById(int: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> getAll(): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}