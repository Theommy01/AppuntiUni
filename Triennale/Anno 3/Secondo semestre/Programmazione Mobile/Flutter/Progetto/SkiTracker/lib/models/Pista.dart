class Pista {
  String nome = "N/A";
  String difficolta = "N/A";
  late int id;
  late int idComprensorio;

  Pista(String nome, String difficolta, int id, int idComprensorio) {
    this.nome = nome;
    this.difficolta = this.getItalianDifficulty(difficolta);
    this.id = id;
    this.idComprensorio = idComprensorio;
  }

  String getItalianDifficulty(String diff) {
    String difficolta = "N/A";

    switch(diff) {
      case 'novice' || 'Novizio':
        difficolta = "Novizio"; break;
      case 'easy' || 'Facile':
        difficolta = "Facile"; break;
      case 'intermediate' || 'Medio':
        difficolta = "Medio"; break;
      case 'advanced' || 'Difficile':
        difficolta = "Difficile"; break;
    }

    return difficolta;
  }

  String getDifficultyWithIndicator() {
    String difficolta = "❓ N/A";

    switch(this.difficolta) {
      case 'Novizio':
        difficolta = "⚪ Novizio"; break;
      case 'Facile':
        difficolta = "🔵 Facile"; break;
      case 'Medio':
        difficolta = "🔴 Medio"; break;
      case 'Difficile':
        difficolta = "⚫ Difficile"; break;
    }

    return difficolta;
  }

  Map<String, dynamic> toMap() {
    return {
      'id': this.id,
      'nome': this.nome,
      'difficolta': this.difficolta,
      'idComprensorio': this.idComprensorio
    };
  }
}