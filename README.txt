Datastructuur is misschien lastig te begrijpen omdat het door elkaar heen staat, maar het is een HashMap (virusMap) met als key een host 'ID (naam)', en als value
een arraylist met virussen, waarvan de virussen dan weer een hostlist hebben, die allemaal tijdens de verwerking van de data nog geupdate kunnen worden.
Dit zodat er niet voor elk virus een nieuw object wordt aangemaakt, terwijl de ID's van sommige virussen (en dus het virus zelf) al wel bekend is.

HashMap - Key: String - Value: ArrayList<Virus>