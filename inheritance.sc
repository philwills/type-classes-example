import com.amazonaws.services.dynamodbv2.model.AttributeValue

trait DynamoFormat[T] {
  def write: AttributeValue
  def read(av: AttributeValue): T
}

object DynamoFormat {
  implicit class StringFormat(s: String)
    extends DynamoFormat[String] {
    override def write =
      new AttributeValue().withS(s)
    override def read(av: AttributeValue) =
      av.getS
  }
}

import DynamoFormat._
// Eugh! Why have I got an empty string here!
"".read("foo".write)