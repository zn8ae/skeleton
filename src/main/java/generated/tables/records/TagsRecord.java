/**
 * This class is generated by jOOQ
 */
package generated.tables.records;


import generated.tables.Tags;

import java.sql.Time;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagsRecord extends UpdatableRecordImpl<TagsRecord> implements Record4<Integer, Time, Integer, String> {

	private static final long serialVersionUID = 1570099053;

	/**
	 * Setter for <code>public.tags.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.tags.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.tags.uploaded</code>.
	 */
	public void setUploaded(Time value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.tags.uploaded</code>.
	 */
	public Time getUploaded() {
		return (Time) getValue(1);
	}

	/**
	 * Setter for <code>public.tags.rid</code>.
	 */
	public void setRid(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.tags.rid</code>.
	 */
	public Integer getRid() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>public.tags.tag</code>.
	 */
	public void setTag(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.tags.tag</code>.
	 */
	public String getTag() {
		return (String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Time, Integer, String> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Time, Integer, String> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Tags.TAGS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Time> field2() {
		return Tags.TAGS.UPLOADED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Tags.TAGS.RID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Tags.TAGS.TAG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Time value2() {
		return getUploaded();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getRid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getTag();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value2(Time value) {
		setUploaded(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value3(Integer value) {
		setRid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value4(String value) {
		setTag(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord values(Integer value1, Time value2, Integer value3, String value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TagsRecord
	 */
	public TagsRecord() {
		super(Tags.TAGS);
	}

	/**
	 * Create a detached, initialised TagsRecord
	 */
	public TagsRecord(Integer id, Time uploaded, Integer rid, String tag) {
		super(Tags.TAGS);

		setValue(0, id);
		setValue(1, uploaded);
		setValue(2, rid);
		setValue(3, tag);
	}
}
