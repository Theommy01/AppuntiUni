@extends('layouts.skel')

@section('title', 'Inserimento nuova azienda')

@section('content')
    <div class="wrapper">
        <!-- box che contiene la form di login -->
        <div class="form-box form-box-inputdialog">
            <h2>Inserisci Azienda</h2>

            <!-- effettiva form di input -->
            {{ Form::open(array('url' => '/inserisciAziende', 'class' => 'contact-form', 'enctype' => 'multipart/form-data')) }}
            <div class="form-row">
                <div class="form-left">
                    {{ Form::label('nome', 'Nome', ['class' => 'label-input']) }}
                    {{ Form::text('nome', '', ['class' => 'input', 'id' => 'nome', 'required' => 'required']) }}
                    @if ($errors->first('nome'))
                        <ul class="errors">
                            @foreach ($errors->get('nome') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('descrizione', 'Descrizione', ['class' => 'label-input']) }}
                    {{ Form::textarea('descrizione', '', ['class' => 'input', 'id' => 'descrizione', 'required' => 'required']) }}
                    @if ($errors->first('descrizione'))
                        <ul class="errors">
                            @foreach ($errors->get('descrizione') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('ragioneSociale', 'Ragione Sociale', ['class' => 'label-input']) }}
                    {{ Form::text('ragioneSociale', '',['class' => 'input', 'id' => 'ragioneSociale', 'required' => 'required']) }}
                    @if ($errors->first('ragioneSociale'))
                        <ul class="errors">
                            @foreach ($errors->get('ragioneSociale') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>

                <div class="form-right">
                    {{ Form::label('tipologia', 'Tipologia', ['class' => 'label-input']) }}
                    {{ Form::text('tipologia', '',['class' => 'input', 'id' => 'tipologia', 'required' => 'required']) }}
                    @if ($errors->first('tipologia'))
                        <ul class="errors">
                            @foreach ($errors->get('tipologia') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('localizzazione', 'Dove si trova', ['class' => 'label-input']) }}
                    {{ Form::textarea('localizzazione', '', ['class' => 'input', 'id' => 'tipologia', 'required' => 'required']) }}
                    @if ($errors->first('localizzazione'))
                        <ul class="errors">
                            @foreach ($errors->get('localizazione') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('logo','Logo di questa azienda' ) }}
                    {{ Form::file('logo', array('required' => 'required')) }}
                    @if ($errors->first('logo'))
                        <ul class="errors">
                            @foreach ($errors->get('logo') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>
            </div>
            {{ Form::submit('Inserisci questa Azienda', ['class' => 'btn'])}}
            {{ Form::close() }}

            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('gestioneAziende') }}">Torna indietro</a>
            </div>
        </div>
    </div>
@endsection

