@extends('layouts.skel')

@section('title', 'Modifica offerta')

@section('content')
    <div class="wrapper">
        <div class="form-box form-box-inputdialog login">
            @if(isset($dati))
            <h2>Aggiorna Offerte</h2>
            <br>

            {{ Form::open(array('url' => '/aggiornaOfferte/'.$dati['id'], 'class' => 'contact-form', 'method'=>'PUT', 'enctype' => 'multipart/form-data')) }}
            @csrf
            <div class="form-row">
                <div class="form-left">
                    <fieldset title="Aggiorna dati offerta">
                        {{ Form::label('nome', 'Nome', ['class' => 'label-input']) }}
                        {{ Form::text('nome', $dati['nome'], ['class' => 'input', 'id' => 'nome', 'required' => 'required']) }}
                        @if ($errors->first('nome'))
                            <ul class="errors">
                                @foreach ($errors->get('nome') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        {{ Form::label('oggettto', 'Oggetto', ['class' => 'label-input']) }}
                        {{ Form::text('oggetto', $dati['oggetto'], ['class' => 'input', 'id' => 'oggetto', 'required' => 'required']) }}
                        @if ($errors->first('oggetto'))
                            <ul class="errors">
                                @foreach ($errors->get('oggetto') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        <label for="idAzienda">Azienda:</label>
                        <p><em>Azienda attuale: {{$dati['idAzienda']}}</em></p>
                        <select id="idAzienda" name="idAzienda" required>
                            <option value="NULL">seleziona</option>
                            @foreach($ListaNomi as $listaNomi)
                                <option value="{{ $listaNomi['id'] }}">{{$listaNomi['id']}}: {{ $listaNomi['nome'] }}</option>
                            @endforeach
                        </select>

                        {{ Form::label('modalitaFruizione', 'Modalità di fruizione', ['class' => 'label-input']) }}
                        {{ Form::text('modalitaFruizione', $dati['modalitaFruizione'], ['class' => 'input', 'id' => 'modalitaFruizione', 'required' => 'required']) }}
                        @if ($errors->first('modalitaFruizione'))
                            <ul class="errors">
                                @foreach ($errors->get('modalitaFruizione') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif
                    </fieldset>
                </div>

                <div class="form-right">
                    <fieldset title="Inserisci dati offerta">
                        {{ Form::label('luogoFruizione', 'Luogo di fruizione', ['class' => 'label-input']) }}
                        {{ Form::text('luogoFruizione', $dati['luogoFruizione'], ['class' => 'input', 'id' => 'luogoFruizione', 'required' => 'required']) }}
                        @if ($errors->first('luogoFruizione'))
                            <ul class="errors">
                                @foreach ($errors->get('luogoFruizione') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        {{ Form::label('dataOraScadenza', 'Data e ora di scadenza', ['class' => 'label-input']) }}
                        {{ Form::datetimeLocal('dataOraScadenza', $dati['dataOraScadenza'] ,['class' => 'input', 'id' => 'dataOraScadenza', 'rules' => 'date_format:d-m-Y H:mm:ss', 'required' => 'required']) }}
                        @if ($errors->first('dataOraScadenza'))
                            <ul class="errors">
                                @foreach ($errors->get('dataOraScadenza') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        <fieldset title="Carica immagini in formato .png o .jpeg">
                            {{ Form::label('immagine','Immagine della offerta', ['class' => 'label-input']) }}
                            <p><em>Immagine attualmete selezionata:</em></p>
                            <img src="data:image/png/jpg/webp/jpeg/bin;base64,{{ base64_encode($dati['immagine']) }}" class="form-image-input-preview" alt="Immagine Offerta">
                            {{ Form::file('immagine') }}
                            @if ($errors->first('immagine'))
                                <ul class="errors">
                                    @foreach ($errors->get('immagine') as $message)
                                        <li>{{ $message }}</li>
                                    @endforeach
                                </ul>
                            @endif
                        </fieldset>
                    </fieldset>
                </div>
            </div>

            {{ Form::submit('Aggiorna offerta', ['class' => 'btn'])}}
            {{ Form::close() }}

            @else
                <h1>Errore: l'offerta selezionata non è disponibile nel database.</h1>
            @endif

            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('gestioneOfferte') }}">Torna indietro</a>
            </div>
        </div>
    </div>
@endsection

