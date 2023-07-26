@extends('layouts.skel')

@section('title', 'Inserimento nuova offerta')

@section('content')
    <!-- il wrapper è il contenitore -->
    <div class="wrapper">

        <div class="form-box form-box-inputdialog login">
            <h2>Inserisci una nuova offerta</h2>

            <!-- effettiva form di input -->
            {{ Form::open(array('url' => '/inserisciOfferte', 'class' => 'contact-form', 'enctype' => 'multipart/form-data')) }}
            @csrf
            <div class="form-row">
                <div class="form-left">
                    <fieldset title="Inserisci dati offerta">
                        {{ Form::label('nome', 'Nome', ['class' => 'label-input']) }}
                        {{ Form::text('nome', '', ['class' => 'input', 'id' => 'nome', 'required' => 'required']) }}
                        @if ($errors->first('nome'))
                            <ul class="errors">
                                @foreach ($errors->get('nome') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        {{ Form::label('oggetto', 'Oggetto', ['class' => 'label-input']) }}
                        {{ Form::text('oggetto', '', ['class' => 'input', 'id' => 'oggetto', 'required' => 'required']) }}
                        @if ($errors->first('oggetto'))
                            <ul class="errors">
                                @foreach ($errors->get('oggetto') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        <fieldset title="ATTENZIONE SE NON SELEZIONATA VERRÀ INSERITA LA PRIMA AZIENDA DISPONIBILE">
                            <label for="idAzienda">Azienda</label>
                            <p><em>Se non selezionato verrà inserita la prima azienda registrata</em></p>
                            <select id="idAzienda" name="idAzienda" required>
                                <option value="NULL">seleziona</option>
                                @foreach($ListaNomi as $listaNomi)
                                    <option value="{{ $listaNomi['nome'] }}">{{$listaNomi['id']}}: {{ $listaNomi['nome'] }}</option>
                                @endforeach
                            </select>
                        </fieldset>

                        {{ Form::label('modalitaFruizione', 'Modalità di fruizione', ['class' => 'label-input']) }}
                        {{ Form::text('modalitaFruizione', '', ['class' => 'input', 'id' => 'modalitaFruizione', 'required' => 'required']) }}
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
                        {{ Form::text('luogoFruizione', '', ['class' => 'input', 'id' => 'luogoFruizione', 'required' => 'required']) }}
                        @if ($errors->first('luogoFruizione'))
                            <ul class="errors">
                                @foreach ($errors->get('luogoFruizione') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        {{ Form::label('dataOraScadenza', 'Data e ora di scadenza', ['class' => 'label-input']) }}
                        {{ Form::datetimeLocal('dataOraScadenza', '',['class' => 'input', 'id' => 'dataOraScadenza', 'rules' => 'date_format:d-m-Y H:mm:ss', 'required' => 'required']) }}
                        @if ($errors->first('dataOraScadenza'))
                            <ul class="errors">
                                @foreach ($errors->get('dataOraScadenza') as $message)
                                    <li>{{ $message }}</li>
                                @endforeach
                            </ul>
                        @endif

                        <fieldset title="Carica immagini in formato .png o .jpeg">
                            {{ Form::label('immagine','Immagine della offerta', ['class' => 'label-input']) }}
                            {{ Form::file('immagine', array('required' => 'required')) }}
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

            {{ Form::submit('Inserisci questa nuova offerta', ['class' => 'btn'])}}
            {{ Form::close() }}
            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('gestioneOfferte') }}">Torna indietro</a>
            </div>
        </div>
    </div>
@endsection
