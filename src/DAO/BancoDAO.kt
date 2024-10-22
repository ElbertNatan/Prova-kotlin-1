package DAO

import model.Pessoa

class BancoDAO private constructor() {

    private lateinit var clientes: ArrayList<Pessoa>

    init {
        clientes =  ArrayList()
    }

    companion object {
        private var banco: BancoDAO? = null

        fun getInstance(): BancoDAO {
            if (banco == null) {
                banco = BancoDAO()
            }
            return banco!!
        }
    }

    fun getArrayPessoas(): ArrayList<Pessoa> {
        return clientes
    }
}
