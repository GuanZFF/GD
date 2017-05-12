package pers.guanzf.common.core.model.info;

import java.util.List;

import pers.guanzf.common.core.model.Person;
import pers.guanzf.common.core.model.PersonProduce;
import pers.guanzf.common.core.model.Produce;

public class PersonProduceInfo extends PersonProduce {

	private List<Produce> produce;

	private Person person;

	public List<Produce> getProduce() {
		return produce;
	}

	public void setProduce(List<Produce> produce) {
		this.produce = produce;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
